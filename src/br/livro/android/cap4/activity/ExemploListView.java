package br.livro.android.cap4.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import br.livro.android.cap4.R;

/**
 * Exemplo simples de ListActivity com SimpleAdapter
 * 
 * Exemplo de utilização de um ListView
 * 
 * @author ricardo
 * 
 */
public class ExemploListView extends Activity implements OnItemClickListener {
	protected static final String CATEGORIA = "livro";
	private ListView listView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Apenas para brincar... sobrescreve o layout do ListView default do Android
		setContentView(R.layout.layout_listview_contatos);

		SimpleAdapter adapter = criaAdaptador();

		listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(this);
	}

	// Cria o adaptador da lista para fornecer o conteúdo
	private SimpleAdapter criaAdaptador() {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		// Cada item na Lista é uma lista
		// Para determinar os valores existe um HashMap para cada linha
		for (int i = 0; i < 30; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("nome", "Nome " + i);
			item.put("fone", "Fone " + i);
			list.add(item);
		}

		// Utiliza o adaptador SimpleAdapter,

		// Array que define as chaves do HashMap
		String[] from = new String[] { "nome", "fone" };

		// nome e fone são definidos no layout_contatos
		int[] to = new int[] { R.id.nome, R.id.fone };
		
		SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.layout_contatos_fone, from, to);
		return adapter;
	}

	public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
		Log.i(CATEGORIA,"ExemploListView.onItemClick posicao: " + posicao + ", id: " + id);

		// Pega o item naquela posição
		Object o = listView.getAdapter().getItem(posicao);

		String item = o.toString();

		// exibe um alerta
		Toast.makeText(this, "Você selecionou: " + item, Toast.LENGTH_SHORT).show();
	}
}
