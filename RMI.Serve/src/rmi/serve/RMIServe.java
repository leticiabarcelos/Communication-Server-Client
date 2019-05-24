package rmi.serve;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import rmi.contrato.*;

public class RMIServe {

    public static void main(String[] args) {
        
        try{
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/chat", new Chat());
            System.out.println("Servidor em execução.....");
        
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    }
    
}
