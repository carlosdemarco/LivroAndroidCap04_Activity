package br.livro.android.cap4.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author rlecheta
 *
 */
public class HelloList extends ListActivity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Create an array of Strings, that will be put to our ListActivity
        String[] mStrings = new String[]{"Android", "Google", "Eclipse"};

        // Create an ArrayAdapter, that will actually make the Strings above appear in the ListView
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));
    }
    
    /**
     * So we say to the system: I want to "android.intent.action.VIEW" a ContentURI "http://anddev.org/search.php?mode=results&search_keywords='" + keyword + "'")); do whatever is needed to acomplish that. And do it now: startActivity(myIntent); 
     * 
     * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
     super.onListItemClick(l, v, position, id);
     
     // Get the item that was clicked
     Object o = this.getListAdapter().getItem(position);
     String keyword = o.toString();

     // Create an VIEW intent
     Intent myIntent = null;
               // The intent will open our anddev.org-board and search for the keyword clicked.
               myIntent = new Intent("android.intent.action.VIEW",
                    Uri.parse("http://anddev.org/search.php?mode=results&search_keywords='"+ keyword + "'"));
          // Start the activity
     startActivity(myIntent);
    }
}
