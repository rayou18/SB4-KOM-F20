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

    public SpaceObject makeSpaceObject(int type, SpaceObject object) { // et til argument; hvor mange instanser skal laves? lav evt et loop per object.

        if (type == 1) {
            return new Bullet(object);
        } else if (type == 2) {

//            for (int i = 0; i < antalInstanser; i++) {
//                add. to list new Enemy();
//            }
            return new Enemy();
        } //else if(type==3) {return new Asteroid}
        else {
            return null;
        }
    }
}
