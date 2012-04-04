package br.livro.android.cap4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Exemplos simples que gera logs nos m�todos de ciclo de vida da Activity
 * 
 * Este exemplo demonstra a navega�ao entre as telas, e logs s�o impressos para monitorar os m�todos chamados
 * 
 * @author ricardo
 *
 */
public class ExemploCicloVidaAbrirTela extends ExemploCicloVida implements OnClickListener {
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Button b = new Button(this);
		b.setText("Clique aqui para abrir a tela.");
		b.setOnClickListener(this);

		setContentView(b);
	}
	public void onClick(View v) {
		Intent it = new Intent(this, Tela2.class);
		it.putExtra("msg", "Zé Maria");		
		startActivity(it);
		
/*		Intent it = new Intent(this,Tela2.class);
		it.putExtra("msg", "Olá");
		startActivity(it);
*/		
	}
}
