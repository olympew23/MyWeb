package com.theironyard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture sheet;
	TextureRegion stand, jump;
	float x, y, xv, yv;
	boolean canJump, faceRight = true;
	Animation<TextureRegion> walk;
	float time;
	static final float MAX_VELOCITY = 500;
	static final int WIDTH = 16;
	static final int HEIGHT = 16;
	static final int DRAW_WIDTH = WIDTH * 5;
	static final int DRAW_HEIGHT = HEIGHT * 5;
	static final float MAX_JUMP_VELOCITY = 2000;
	static final int GRAVITY = -50;




	@Override
	public void create () {
		batch = new SpriteBatch();
		sheet = new Texture("tiles.png");
	TextureRegion[][] grid = TextureRegion.split(sheet,16,16);
		TextureRegion down = grid[6][0];
		TextureRegion up = grid[6][1];
		TextureRegion right = grid[6][3];
		TextureRegion left = new TextureRegion(right);
		left.flip(true, false);
		walk = new Animation(0.5f, grid [0][6], grid[0][3], grid[0][4]);

	}

	@Override
	public void render () {

		time += Gdx.graphics.getDeltaTime();

		move();

		TextureRegion img;
		if (y > 0) {
			img = jump;
		}
		else if (xv != 0) {
			img = walk.getKeyFrame(time, true);
		}
		else {
			img = stand;
		}




		Gdx.gl.glClearColor(0, 0, 5, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (faceRight) {
			batch.draw(img, x, y, DRAW_WIDTH, DRAW_HEIGHT);
		}
		else {
			batch.draw(img, x + DRAW_WIDTH, y, DRAW_WIDTH * -1, DRAW_HEIGHT);
		}

		batch.end();
	}



	@Override
	public void dispose () {
		batch.dispose();

	}

	float decelerate(float velocity) {
		float deceleration = 0.95f; // the closer to 1, the slower the deceleration
		velocity *= deceleration;
		if (Math.abs(velocity) < 1) {
			velocity = 0;
		}
		return velocity;


	}

	void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.UP) && canJump) {
			yv = MAX_JUMP_VELOCITY;
			canJump = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			yv = MAX_VELOCITY * -1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			xv = MAX_VELOCITY;
			faceRight = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			xv = MAX_VELOCITY * -1;
			faceRight = false;
		}

		yv += GRAVITY;

		y += yv * Gdx.graphics.getDeltaTime();
		x += xv * Gdx.graphics.getDeltaTime();

		if (y < 0) {
			y = 0;
			canJump = true;
		}

		yv = decelerate(yv);
		xv = decelerate(xv);
	}



}
