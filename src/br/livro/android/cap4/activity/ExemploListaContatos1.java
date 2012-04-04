package br.livro.android.cap4.activity;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Exemplo de ListActivity que utiliza o SimpleCursorAdapter
 * para enviar os dados do Cursor de contatos para uma view definida em XML
 * 
 * @author ricardo
 *
 */
public class ExemploListaContatos1 extends ListActivity {
	private ListAdapter mAdapter;

    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Uri para buscar os contatos
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        //Recupera o cursor dos contatos
        Cursor c = getContentResolver().query(uri, null, null, null, null);
        startManagingCursor(c);

        //Listar o nome e telefone do contato
        String[] columns = new String[]{ContactsContract.Contacts.DISPLAY_NAME};

        int[] to = new int[] { android.R.id.text1};

        //Informe o adapter para ligar os valores ao XML da View
        int layoutNativo = android.R.layout.simple_list_item_1;
		mAdapter = new SimpleCursorAdapter(this, layoutNativo, c, columns, to);

        setListAdapter(mAdapter);
    }

    /**
     * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //recupera o cursor na posição selecionada
        Cursor c = (Cursor) mAdapter.getItem(position);

        //recupera o Nome e Telefone
        String nome = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));

        Toast.makeText(this,"Contato selecionado: " + nome,Toast.LENGTH_SHORT).show();
    }
}
