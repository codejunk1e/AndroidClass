package io.github.persistence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.gkemon.XMLtoPDF.PdfGenerator
import com.gkemon.XMLtoPDF.PdfGeneratorListener
import com.gkemon.XMLtoPDF.model.FailureResponse
import com.gkemon.XMLtoPDF.model.SuccessResponse
import io.github.persistence.databinding.ActivityMainBinding
import io.github.persistence.databinding.ShoppingItemBinding



const val CATEGORY_KEY =  "CATEGORY_KEY"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>
    private lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ShoppingViewModel::class.java]

        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList){
        }
        binding.recyclerView.adapter = myShoppingAdapter
        binding.button2.setOnClickListener {
            generatePdf(this, binding.root)
        }

        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllShoppingItems(db).observe(this, {
            myShoppingAdapter = ShoppingAdapter(it){}
            binding.recyclerView.adapter = myShoppingAdapter
            myShoppingAdapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val category : String = binding.editText.text.toString()
            val description : String = binding.editText2.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            viewModel.addShoppingItem(shoppingItem, db)

            myShoppingAdapter.notifyDataSetChanged()
        }
    }


    fun generatePdf(context: Context, viewToPrint: View) {
        PdfGenerator.getBuilder()
            .setContext(context)
            .fromViewSource()
            .fromView(viewToPrint)
            .setPageSize(PdfGenerator.PageSize.A4)
            .setFileName("my_table")
            .setFolderName("table_prize/")
            .openPDFafterGeneration(true)
            .build(object : PdfGeneratorListener() {

                override fun onFailure(failureResponse: FailureResponse) {
                    super.onFailure(failureResponse)
                    Toast.makeText(context, "$failureResponse.errorMessage", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun showLog(log: String) {
                    super.showLog(log)
                }

                override fun onStartPDFGeneration() {}
                override fun onFinishPDFGeneration() {}

                override fun onSuccess(response: SuccessResponse) {
                    super.onSuccess(response)
                }
            })
    }
}
