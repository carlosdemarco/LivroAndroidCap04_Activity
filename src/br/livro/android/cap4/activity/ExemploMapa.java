package br.livro.android.cap4.activity;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

/**
 * Hello World com MapActivity
 * 
 * @author ricardo
 * 
 */
public class ExemploMapa extends MapActivity {
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Cria o MapView
		MapView map = new MapView(this,"0_p5UdGhSq-qZx6c4_kYQIwxsUwEH2P4H-yatxA");

		// Exibe o MapView na tela
		setContentView(map);
	}
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
