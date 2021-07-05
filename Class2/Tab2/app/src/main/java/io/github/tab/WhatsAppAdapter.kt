package io.github.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.tab.views.CallsFragment
import io.github.tab.views.ChatsFragment
import io.github.tab.views.StatusFragment

class WhatsAppAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Chatsjjj"
            1 -> return "Statusjjj"
            2 -> return "Callsjjj"
            else -> return "Chats"
        }
    }

    override fun getCount(): Int {
        return  3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ChatsFragment()
            1 -> return StatusFragment()
            2 -> return CallsFragment()
            else -> return ChatsFragment()
        }
    }
}