package br.livro.android.cap4.activity;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import br.livro.android.cap4.R;

/**
 * Exemplo de ListActivity que utiliza o SimpleCursorAdapter para enviar os
 * dados do Cursor de contatos para uma view definida em XML
 * 
 * @author ricardo
 * 
 */
public class ExemploListaContatos2_Android_1_5 extends ListActivity {
	private ListAdapter adaptador;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

        // Para customizar o ListView com nosso Layout.
        // Isto não é obrigatório se o layout do Android agradar você.
        setContentView(R.layout.layout_listview_contatos);

		// Recupera o cursor dos contatos
		Cursor c = getContentResolver().query(Contacts.People.CONTENT_URI,null, null, null, null);
		startManagingCursor(c);

		// Listar o nome e telefone do contato
		String[] colunas = new String[] { Contacts.People.NAME,Contacts.People.NUMBER };
		int[] campos = new int[] { R.id.nome, R.id.fone };

		// Informe o adapter para ligar os valores ao XML da View
		adaptador = new SimpleCursorAdapter(this, R.layout.layout_contatos, c,colunas, campos);

		setListAdapter(adaptador);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// recupera o cursor na posição selecionada
		Cursor c = (Cursor) adaptador.getItem(position);

		// recupera o Nome e Telefone
		String nome = c.getString(c.getColumnIndexOrThrow(Contacts.People.NAME));
		String fone = c.getString(c.getColumnIndexOrThrow(Contacts.People.NUMBER));

		Toast.makeText(this,"Você selecionou: Nome: " + nome + ", Fone: " + fone,Toast.LENGTH_SHORT).show();
	}
}
