package br.livro.android.cap4.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Exemplo simples de ListActivity com ArrayAdapter
 * 
 * @author ricardo
 *
 */
public class ExemploListActivity1 extends ListActivity {
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Array de Strings para visualizar na Lista
		String[] itens = new String[] { "Nome 1", "Nome 2", "Nome 3", "Nome 4" };

		// Utiliza o adaptador ArrayAdapter, para exibir o array de Strings na tela.
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itens);

		setListAdapter(adaptador);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// Pega o item naquela posição
		Object o = this.getListAdapter().getItem(position);

		String item = o.toString();

		//Exibe um alerta
		Toast.makeText(this, "Você selecionou: " + item, Toast.LENGTH_SHORT).show();
	}
}
