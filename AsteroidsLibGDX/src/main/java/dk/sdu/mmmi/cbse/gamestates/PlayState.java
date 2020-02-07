package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.entities.SpaceObject;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import dk.sdu.mmmi.cbse.managers.SpaceObjectFactory;
import java.util.ArrayList;
import java.util.Random;

public class PlayState extends GameState {

    private ShapeRenderer sr;
    private SpaceObjectFactory factory;
    private Player player;
    private Enemy enemy;
    private Bullet bullet;
    ArrayList<Bullet> playerBullets;
    ArrayList<Enemy> enemies;
    ArrayList<Bullet> individualListOfBullets;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        factory = new SpaceObjectFactory();
        sr = new ShapeRenderer();
        player = new Player();
        //enemy = new Enemy();
        playerBullets = new ArrayList<Bullet>();
        
        enemies = new ArrayList<Enemy>();
        individualListOfBullets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("enemy added to list");
            enemies.add((Enemy)factory.makeSpaceObject(2, player));
            
       
        }

    }

    public void update(float dt) {

        handleInput();
      

        player.update(dt);
        //enemy.update(dt);

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update(dt);
            
        }

        try {
            for (int i = 0; i < playerBullets.size(); i++) {
                playerBullets.get(i).update(dt);
            }

        } catch (Exception E) {
            System.out.println("bullet not spawned yet");
        }

        if (playerBullets.size() > 4) {
            playerBullets.remove(0);
        }
        
        try {
            for(Bullet bullet : individualListOfBullets){
                bullet.update(dt);
            }
        }
        catch(Exception e){
            
        }
    }

    public void draw() {
        player.draw(sr);
        //enemy.draw(sr);
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(sr);
        }

        try {
            for (int i = 0; i < playerBullets.size(); i++) {
                playerBullets.get(i).draw(sr);
            }

        } catch (Exception E) {
            System.out.println("bullet not spawned yet");
        }
        
         try {
            for(Bullet bullet : individualListOfBullets){
                bullet.draw(sr);
            }
        }
        catch(Exception e){
            
        }
    }

    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));

        if (GameKeys.isPressed(GameKeys.SPACE)) {

            playerBullets.add((Bullet) factory.makeSpaceObject(1, player));
            System.out.println("Bullet added to list");
              
        }
        
        if(GameKeys.isPressed(GameKeys.ENTER)){
            
            for(Enemy enemy : enemies){
                 individualListOfBullets.add((Bullet) factory.makeSpaceObject(1, enemy));
            }
           
        }
    }

   

    public void dispose() {
    }

}
