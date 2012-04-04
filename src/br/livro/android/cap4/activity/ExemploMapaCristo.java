package br.livro.android.cap4.activity;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

/**
 * Exemplo de Mapas que centraliza no Cristo Redentor
 * 
 * @author ricardo
 *
 */
public class ExemploMapaCristo extends MapActivity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Cria o MapView
		MapView map = new MapView(this, "0_p5UdGhSq-qZx6c4_kYQIwxsUwEH2P4H-yatxA");

		MapController mc = map.getController();

		// faz zoom (valores de 1 a 21)
		mc.setZoom(19);

		// Coorenadas GPS do Cristo Rendendor - Rio de Janeiro
		double latitude = -22.951285 * 1E6; /* 1000000 */

		double longitude = -43.211262 * 1E6 /* 1000000 */;

		// Cria o Ponto com a Latitude e Longitude
		GeoPoint point = new GeoPoint((int) latitude, (int) longitude);

		// centraliza o mapa no Cristo
		mc.setCenter(point);

		// ativa o modo satélite no Mapa
		map.setSatellite(true);

		// Exibe o MapView na tela
		setContentView(map);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
