package rmi.Contrato;

import java.rmi.*;
import java.util.List;

public interface IChat extends Remote{
    
    public boolean enviar (String msg, int id) throws RemoteException;
    public List<String> receber() throws RemoteException;
    public int acessar (String nome) throws RemoteException; 
    
}
