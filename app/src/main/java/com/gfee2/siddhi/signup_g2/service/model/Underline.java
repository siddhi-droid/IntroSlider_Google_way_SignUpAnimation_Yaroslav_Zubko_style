package com.gfee2.siddhi.signup_g2.service.model;

/**
 * Created by siddhi on 3/20/2018.
 */

public class Underline {
  float fromX, fromY, toX, toY;

  public Underline() {
  }

  public Underline(float fromX, float fromY, float toX, float toY) {
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
  }

  public void from(float x, float y) {
    this.fromX = x;
    this.fromY = y;
  }

  public void to(float x, float y) {
    this.fromX = x;
    this.fromY = y;
  }

  public float getFromX() {
    return fromX;
  }

  public void setFromX(float fromX) {
    this.fromX = fromX;
  }

  public float getFromY() {
    return fromY;
  }


  public void setFromY(float fromY) {
    this.fromY = fromY;
  }

  public float getToX() {
    return toX;
  }

  public void setToX(float toX) {
    this.toX = toX;
  }

  public float getToY() {
    return toY;
  }

  public void setToY(float toY) {
    this.toY = toY;
  }
}
