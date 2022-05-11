package com.example.xodim.Service;

import com.example.xodim.Been.XaridorBeen;
import com.example.xodim.Model.Xaridor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XaridorService {

    @Autowired
    XaridorBeen xaridorBeen;

    public String insert(Xaridor xaridor){
        boolean b = xaridorBeen.existsByTelefonRaqam(xaridor.getTelefonRaqam());
        if (b) {
            return "Bunday xaridor mavjud";
        }
        Xaridor xaridor1 = new Xaridor();
        xaridor1.setIsm(xaridor.getIsm());
        xaridor1.setFamiliya(xaridor.getFamiliya());
        xaridor1.setTelefonRaqam(xaridor.getTelefonRaqam());
        xaridor1.setManzil(xaridor.getManzil());
        xaridorBeen.save(xaridor1);
        return "Joylandi";
    }

    public List<Xaridor> select(){
        return xaridorBeen.findAll();
    }

    public  String update(Integer id, Xaridor xaridor){
        Optional<Xaridor> optional=xaridorBeen.findById(id);
        if(optional.isPresent()){
            Xaridor xaridor1=optional.get();
            xaridor1.setIsm(xaridor.getIsm());
            xaridor1.setFamiliya(xaridor.getFamiliya());
            xaridor1.setTelefonRaqam(xaridor.getTelefonRaqam());
            xaridor1.setManzil(xaridor.getManzil());
            xaridorBeen.save(xaridor1);
            return "Yangilandi";
        }
        return "Bunday malumot yo'q";
    }

    public  String delete(Integer id){
        Optional<Xaridor> optional=xaridorBeen.findById(id);
        if(optional.isPresent()){
            xaridorBeen.deleteById(id);
            return "O'chirildi";
        }
        return "Bunday malumot yo'q";
    }

    public Xaridor getXaridorbyId(Integer id){
        Optional<Xaridor> optionalXaridor = xaridorBeen.findById(id);

//        if (optionalXaridor.isPresent()){
//            return optionalXaridor.get();
//        }
//        return null;
        return optionalXaridor.orElse(null);
    }
}
