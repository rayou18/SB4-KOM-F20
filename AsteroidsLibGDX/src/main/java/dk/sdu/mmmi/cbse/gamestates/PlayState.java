package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import java.util.Random;

public class PlayState extends GameState {
    
    private ShapeRenderer sr;
    
    private Player player;
    private Enemy enemy;
    private Bullet bullet;
    
    public PlayState(GameStateManager gsm) {
        super(gsm);
    }
    
    public void init() {
        
        sr = new ShapeRenderer();
        
        player = new Player();
        enemy = new Enemy();
        bullet = new Bullet();
        
    }
    
    public void update(float dt) {
        
        handleInput();
        enemyMovement();
        
        player.update(dt);
        enemy.update(dt);
        try {
             player.getBullet().update(dt);
        } catch (java.lang.NullPointerException E) {
            System.out.println("bullet not spawned yet");
        }
    }
    
    public void draw() {
        player.draw(sr);
        enemy.draw(sr);
        try {
            player.getBullet().draw(sr);
        } catch (java.lang.NullPointerException E) {
            System.out.println("bullet not spawned yet");
        }
    }
    
    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));
        player.shootBullet(GameKeys.isPressed(GameKeys.SPACE));
    }
    
    public void enemyMovement() {
        
        double ran = Math.random() * 2;

        //left
        if (ran < 1) {
            enemy.setLeft(true);
            enemy.setRight(false);
            enemy.setUp(true);
        }
        //right
        if (ran > 1 && ran < 2) {
            enemy.setRight(true);
            enemy.setUp(true);
            enemy.setLeft(false);
        }
        //up
        if (ran == 2) {
            enemy.setUp(true);
            enemy.setLeft(false);
            enemy.setRight(false);
        }
        
    }
    
    public void dispose() {
    }
    
}
