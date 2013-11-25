
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeUtility;



public class ComandosUsuarioSingleton {
	
	 private static ComandosUsuarioSingleton singleton=null;
	 public static Usuario actual = null;
	 public static int tot;
	 public static int nivel;
	 private ComandosUsuarioSingleton(){}

	 public static ComandosUsuarioSingleton getSingleton(){
	  if(singleton==null){
	   singleton=new ComandosUsuarioSingleton();
	  }
	  return singleton;
	 }
	 
	 
	 public void registrar(Usuario nuevo) throws IOException, ClassNotFoundException
	 {
		 ArrayList<Usuario> lista = obtenerusuarios();
		 lista.add(nuevo);
		 try
	      {
	         FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         while(lista.isEmpty() == false)
	         {
	        	 Usuario e = lista.get(0);
	        	 out.writeObject(e);
	        	 lista.remove(0);
	         }
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		 
	 }
	 
	 public ArrayList<Usuario> obtenerusuarios()throws IOException, ClassNotFoundException
	 {
		 ArrayList<Usuario> lista = new ArrayList<Usuario>();
		 try
	      {
	         FileInputStream fileIn = new FileInputStream("usuarios.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         while(fileIn.available() > 0)
	         {
	        	 Usuario aux = new Usuario();
	        	 aux = (Usuario) in.readObject();
	        	 lista.add(aux);
	         }
	         in.close();
	         fileIn.close();
	         lista.remove(null);
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }
		 return lista;
	 }
	 
	 public boolean comprobar(Usuario iden, Usuario actu)
	 {
		 if(actu.login.equals(iden.login) && actu.pass.equals(iden.pass))
		 {
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean verificarlogin(Usuario iden) throws ClassNotFoundException, IOException
	 {
		 ArrayList<Usuario> lista = obtenerusuarios();
		 Usuario aux = null;
		 while(lista.isEmpty() == false)
		 {
			 aux = lista.get(0);
			 if(comprobar(iden,aux))
			 {
				 actual = aux;
				 return true;
			 }
			 lista.remove(0);
		 }
		 return false;
	 }
	 
	 public void logoff() throws ClassNotFoundException, IOException
	 {
		 actual = null;
	 }
	 
	 public ArrayList<Usuario> devolverordenadonivel(ArrayList<Usuario> lista, int nivel, boolean modo)
	 {
		 ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		 Usuario aux1 ,aux2,aux3;
		 for(int i = 0; i < lista.size(); i++)
		 {
			 if(modo == true) //mayor
			 {
				 switch(nivel)
				 {
					 case 1:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagefacil > aux2.puntagefacil)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
					 
					 case 2:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagemedio > aux2.puntagemedio)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
					 
					 case 3:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagedificil > aux2.puntagedificil)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
				 }
			 }
			 else
			 {
				 switch(nivel)
				 {
					 case 1:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagefacil < aux2.puntagefacil)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
					 
					 case 2:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagemedio < aux2.puntagemedio)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
					 
					 case 3:
						 aux1 = lista.get(i);
						 for(int x =0; x < resultado.size(); x++)
						 {
							 aux2 = resultado.get(x);
							 if(aux1.puntagedificil < aux2.puntagedificil)
							 {
								 aux3 = aux2;
								 resultado.remove(x);
								 resultado.add(x, aux1);
								 aux1 = aux3;
							 }
						 }
						 resultado.add(aux1);
					 break;
				 }
			 }
		 }
		 resultado.remove(null);
		 return resultado;
	 }
	 
	 public void actualizarusuario(Usuario nuevo, Usuario antiguo) throws IOException, ClassNotFoundException
	 {
		 ArrayList<Usuario> lista = obtenerusuarios();
		 lista.add(nuevo);
		 try
	      {
	         FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         while(lista.isEmpty() == false)
	         {
	        	 Usuario e = lista.get(0);
	        	 if(e.ci == antiguo.ci )
	        	 {
	        		 e = nuevo;
	        	 }
	        	 out.writeObject(e);
	        	 lista.remove(0);
	         }
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		 
	 }
	 
}
