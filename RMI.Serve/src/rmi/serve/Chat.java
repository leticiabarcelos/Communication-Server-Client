package rmi.serve;

import java.rmi.*;
import java.util.*;
import rmi.Contrato.*;
import java.rmi.server.UnicastRemoteObject;

public class Chat extends UnicastRemoteObject implements IChat{
    
    private Map<Integer, String> usuarios;
    private static List<String> mensagens;
    
    public Chat()throws RemoteException{
        if(usuarios == null){
            usuarios = new HashMap<>();
        }
        
        if(mensagens == null){
            mensagens = new ArrayList<>();
        }
    }

    @Override
    public boolean enviar(String msg, int id) throws RemoteException {
        if(usuarios.containsKey(id)){
            String nome = usuarios.get(id);
            mensagens.add(nome + ": " + msg);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<String> receber() throws RemoteException {
        return mensagens;
    }

    @Override
    public int acessar(String nome) throws RemoteException {
        int id = (int)(Math.random() * 999999999);
        usuarios.put(id, nome);
        return id;
        
    }
    
}
