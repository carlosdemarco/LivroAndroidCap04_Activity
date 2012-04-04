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
import br.livro.android.cap4.R;

/**
 * Exemplo de ListActivity que utiliza o SimpleCursorAdapter para ler os
 * contatos da agenda
 * 
 * Ao selecionar o contato o nome � exibido
 * 
 * @author ricardo
 * 
 */
public class ExemploListaContatos2 extends ListActivity {
	private ListAdapter adaptador;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Para customizar o ListView com nosso Layout.
		// Utilize isto se o layout do Android agradar você.
		// setContentView(R.layout.layout_listview_contatos);

		// Uri para buscar os contatos
		Uri uri = ContactsContract.Contacts.CONTENT_URI;

		// Recupera o cursor dos contatos
		Cursor c = getContentResolver().query(uri, null, null, null, null);
		startManagingCursor(c);

		// Listar o nome e telefone do contato
		String[] colunas = new String[] { ContactsContract.Contacts.DISPLAY_NAME };
		int[] campos = new int[] { R.id.nome };

		// Informe o adapter para ligar os valores ao XML da View
		adaptador = new SimpleCursorAdapter(this, R.layout.layout_contatos, c, colunas, campos);

		setListAdapter(adaptador);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// recupera o cursor na posição selecionada
		Cursor c = (Cursor) adaptador.getItem(position);

		// recupera o Nome e Telefone
		String nomeColuna = ContactsContract.Contacts.DISPLAY_NAME;
		String nome = c.getString(c.getColumnIndexOrThrow(nomeColuna));

		Toast.makeText(this, "Contato selecionado: " + nome,Toast.LENGTH_SHORT).show();
	}
}
