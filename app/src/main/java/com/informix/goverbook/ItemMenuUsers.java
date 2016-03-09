package com.informix.goverbook;

import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.informix.goverbook.adapters.WorkersListAdapter;
import com.informix.goverbook.fragments.WorkersFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adm on 02.02.2016.
 */
public class ItemMenuUsers {
    ArrayList<UserContact> userContact;


    public ItemMenuUsers(ArrayList<UserContact> userContacts) {
        this.userContact = userContacts;
    }

    public void DrawMenu(ListView searchResult){

        String[] names=new String[userContact.size()];
        String[] orgs=new String[userContact.size()];

        for (int i=0;i<userContact.size();i++) {
            names[i]=userContact.get(i).getFIO();
            orgs[i]=userContact.get(i).getORG();
        }
        WorkersListAdapter adapter = new WorkersListAdapter(searchResult.getContext(),names,orgs);
        searchResult.setAdapter(adapter);

    }

    public void DrawMenuWithStatus(ListView searchResult){

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0;i<userContact.size();i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("fio", userContact.get(i).getFIO());
            datum.put("status", userContact.get(i).getSTATUS());
            data.add(datum);
        }

        SimpleAdapter adapter1 = new SimpleAdapter(searchResult.getContext(), data,
                android.R.layout.simple_list_item_2,
                new String[] {"fio", "status"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});

        searchResult.setAdapter(adapter1);

    }

    public void DrawUsersOnOrg(ExpandableListView searchResult){
        for (int i=0;i<userContact.size();i++){


        }
    }

}
