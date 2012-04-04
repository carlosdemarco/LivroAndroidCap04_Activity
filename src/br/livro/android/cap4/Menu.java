package br.livro.android.cap4;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.livro.android.cap4.activity.ExemploCicloVidaAbrirTela;
import br.livro.android.cap4.activity.ExemploListActivity1;
import br.livro.android.cap4.activity.ExemploListView;
import br.livro.android.cap4.activity.ExemploListaContatos1;
import br.livro.android.cap4.activity.ExemploListaContatos2;
import br.livro.android.cap4.activity.ExemploMapa;
import br.livro.android.cap4.activity.ExemploMapaCristo;
import br.livro.android.cap4.activity.ExemploSimplesAdapter1;
import br.livro.android.cap4.activity.ExemploSimplesAdapter2;
import br.livro.android.cap4.activity.provider.ListActivityCursorCarros;
import br.livro.android.cap4.activity.smile.ExemploSmileAdapter;

/**
 * Exemplos de Activity (ListActivity, MapActivity)
 * 
 * Demonstra também um ListActivity que utiliza o Content Provider de Carros para obter o Cursor
 * 
 * Obs: Para funcionar o pacote do ContentProvider de carros precisa estar instalado
 * 
 * @author rlecheta
 * 
 */
public class Menu extends ListActivity {
	private static final String[] nomes = new String[] { 
			"Ciclo de Vida", "ArrayAdapter", "SimpleAdapter1", "SimpleAdapter2", "ExemploListView",
			"CursorAdapter 1", "CursorAdapter 2", "Cursor de Carros", "Customizado - Smile",
			"MapActivity", "MapActivity - Cristo", "Sair"};

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
			case 0:
				startActivity(new Intent(this,ExemploCicloVidaAbrirTela.class));
				break;
			case 1:
				startActivity(new Intent(this,ExemploListActivity1.class));
				break;
			case 2:
				startActivity(new Intent(this,ExemploSimplesAdapter1.class));
				break;
			case 3:
				startActivity(new Intent(this,ExemploSimplesAdapter2.class));
				break;
			case 4:
				startActivity(new Intent(this,ExemploListView.class));
				break;
			case 5:
				startActivity(new Intent(this,ExemploListaContatos1.class));
				break;
			case 6:
				startActivity(new Intent(this,ExemploListaContatos2.class));
				break;
			case 7:
				startActivity(new Intent(this,ListActivityCursorCarros.class));
				break;
			case 8:
				startActivity(new Intent(this,ExemploSmileAdapter.class));
				break;
			case 9:
				startActivity(new Intent(this,ExemploMapa.class));
				break;
			case 10:
				startActivity(new Intent(this,ExemploMapaCristo.class));
				break;
			default:
				//Encerra a activity (encerra o ciclo de vida)
				finish();
		}
	}
}