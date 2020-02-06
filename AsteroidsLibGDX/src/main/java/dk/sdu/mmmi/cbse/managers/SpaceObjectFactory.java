/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.managers;

import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.entities.SpaceObject;

/**
 *
 * @author Rami
 */
public class SpaceObjectFactory {
    
    
    public SpaceObject makeSpaceObject(int type, Player player){
        
        if(type==1){
            return new Bullet(player);
        }
        else if(type==2){
        return new Enemy();
        }
        else return null;
    }
}
