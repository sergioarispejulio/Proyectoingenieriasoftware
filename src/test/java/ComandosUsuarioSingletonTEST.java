
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ComandosUsuarioSingletonTEST {

ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton(); 
	
	@Test
	public void registrarUsuarioadmi() throws Exception {
		Usuario nuevo = new Usuario();
		ArrayList<Usuario> lista = singleton.obtenerusuarios();
		int cant = lista.size();
		nuevo.ci = 123;
		nuevo.login = "pedro";
		nuevo.pais = "narnia";
		nuevo.admi = true;
		nuevo.pass = "prueba";
		singleton.registrar(nuevo);
		lista = singleton.obtenerusuarios();
		assertEquals(cant+1, lista.size());
	}

	@Test
	public void registrarUsuario() throws Exception {
		Usuario nuevo = new Usuario();
		ArrayList<Usuario> lista = singleton.obtenerusuarios();
		int cant = lista.size();
		nuevo.ci = 123;
		nuevo.login = "Pedro";
		nuevo.pais = "narnia";
		nuevo.admi = false;
		nuevo.pass = "prueba";
		singleton.registrar(nuevo);
		lista = singleton.obtenerusuarios();
		assertEquals(cant+1, lista.size());
	}


	@Test
	public void ordenarmenordificil() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagedificil = 13;
		actu2.puntagedificil = 23;
		actu3.puntagedificil = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu3);
		prueba.add(actu2);
		prueba.add(actu1);
		resul.add(actu1);
		resul.add(actu2);
		resul.add(actu3);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 3, false);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void ordenarmenormedio() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagemedio = 13;
		actu2.puntagemedio = 23;
		actu3.puntagemedio = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu3);
		prueba.add(actu2);
		prueba.add(actu1);
		resul.add(actu1);
		resul.add(actu2);
		resul.add(actu3);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 2, false);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void ordenarmenorfacil() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagefacil = 13;
		actu2.puntagefacil = 23;
		actu3.puntagefacil = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu3);
		prueba.add(actu2);
		prueba.add(actu1);
		resul.add(actu1);
		resul.add(actu2);
		resul.add(actu3);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 1, false);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void ordenarmayordificil() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagedificil = 13;
		actu2.puntagedificil = 23;
		actu3.puntagedificil = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu1);
		prueba.add(actu2);
		prueba.add(actu3);
		resul.add(actu3);
		resul.add(actu2);
		resul.add(actu1);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 3, true);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void ordenarmayormedio() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagemedio = 13;
		actu2.puntagemedio = 23;
		actu3.puntagemedio = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu1);
		prueba.add(actu2);
		prueba.add(actu3);
		resul.add(actu3);
		resul.add(actu2);
		resul.add(actu1);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 2, true);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void ordenarmayorfacil() throws Exception {
		Usuario actu1 = new Usuario();
		Usuario actu2 = new Usuario();
		Usuario actu3 = new Usuario();
		actu1.puntagefacil = 13;
		actu2.puntagefacil = 23;
		actu3.puntagefacil = 33;
		ArrayList<Usuario> prueba = new ArrayList<Usuario>();
		ArrayList<Usuario> resul = new ArrayList<Usuario>();
		prueba.add(actu1);
		prueba.add(actu2);
		prueba.add(actu3);
		resul.add(actu3);
		resul.add(actu2);
		resul.add(actu1);
		prueba.remove(null);
		resul.remove(null);
		ArrayList<Usuario> resul1 = singleton.devolverordenadonivel(prueba, 1, true);
		assertEquals(resul, resul1);
	}
	
	@Test
	public void logoff() throws Exception {
		Usuario actu = new Usuario();
		actu.ci = 123;
		actu.login = "Pedro";
		actu.pais = "narnia";
		actu.pass = "prueba";
		singleton.actual = actu;
		singleton.logoff();
		assertEquals(null, singleton.actual);
	}
	
	@Test
	public void login() throws Exception {
		Usuario actu = new Usuario();
		actu.ci = 123;
		actu.login = "Pedro";
		actu.pais = "narnia";
		actu.pass = "prueba";
		assertEquals(true, singleton.verificarlogin(actu));
	}
	
	@Test
	public void comprobarNo() throws Exception {
		Usuario nuevo = new Usuario();
		Usuario actu = new Usuario();
		nuevo.ci = 123;
		nuevo.login = "pedro";
		nuevo.pais = "narnia";
		nuevo.pass = "prueba";
		actu.ci = 123;
		actu.login = "Pedro";
		actu.pais = "narnia";
		actu.pass = "prueba";
		singleton.actual = actu;
		assertEquals(false, singleton.comprobar(nuevo,actu));
	}
	
	@Test
	public void comprobarSi() throws Exception {
		Usuario nuevo = new Usuario();
		Usuario actu = new Usuario();
		nuevo.ci = 123;
		nuevo.login = "Pedro";
		nuevo.pais = "narnia";
		nuevo.pass = "prueba";
		actu.ci = 123;
		actu.login = "Pedro";
		actu.pais = "narnia";
		actu.pass = "prueba";
		singleton.actual = actu;
		assertEquals(true, singleton.comprobar(nuevo,actu));
	}
	
	@Test
	public void actualizarUsuario() throws Exception {
		Usuario nuevo = new Usuario();
		Usuario nuevo1 = new Usuario();
		ArrayList<Usuario> lista = singleton.obtenerusuarios();
		nuevo.ci = 123;
		nuevo.login = "ana";
		nuevo.pais = "narnia";
		nuevo.admi = false;
		nuevo.pass = "prueba";
		singleton.registrar(nuevo);
		nuevo1.login = "ana1";
		nuevo1.pais = "narnia";
		nuevo1.admi = false;
		nuevo1.pass = "prueba1";
		singleton.actualizarusuario(nuevo1, nuevo);
		lista = singleton.obtenerusuarios();
		int cant = lista.size();
		assertEquals(nuevo1.ci, lista.get(cant-1).ci);
		assertEquals(nuevo1.login, lista.get(cant-1).login);
		assertEquals(nuevo1.nombre, lista.get(cant-1).nombre);
	}

}
