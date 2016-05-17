/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import nf.*;
/**
 *
 * @author Quentin Bonenfant
 */
public class OrderData {
    
    private static HashMap<String,SpecieCategory> categoryList;

    public static HashMap getCategories(){
        return(categoryList);
    }
    
    public String[] getListSpecieFromCat(String cat){
	ArrayList<String> res = new ArrayList<>();
	SpecieCategory sCat = categoryList.get(cat);
        Set<Specie> setSpe = sCat.getSpecies();
        List<Specie> list = new ArrayList<>(setSpe);
        for (Specie list1 : list) {
            res.add(list1.getName());
        }
        String[] result = new String[ res.size() ];
        return res.toArray( result );
    }
}


