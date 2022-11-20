// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private AHRS gyro;
  private TalonFX leftFront, leftBack, rightFront, rightBack;
  public Drivetrain() {
    gyro = new AHRS();
    leftFront = new TalonFX(0);
    leftBack = new TalonFX(2);
    rightFront = new TalonFX(3);
    rightBack = new TalonFX(1);
    leftFront.setInverted(TalonFXInvertType.CounterClockwise);
    leftBack.setInverted(TalonFXInvertType.CounterClockwise);
    rightFront.setInverted(TalonFXInvertType.Clockwise);
    rightBack.setInverted(TalonFXInvertType.Clockwise);
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void log(){
    SmartDashboard.putNumber("Output", leftFront.getMotorOutputPercent());
    SmartDashboard.putNumber("Output",rightFront.getMotorOutputPercent());
  }

  public void setSpeeds(double left, double right){
    leftFront.set(ControlMode.PercentOutput, left);
    rightFront.set(ControlMode.PercentOutput, right);
  }

  public void stopMotors(){
    setSpeeds(0, 0);
  }

  //Run motors forward at certain speed
  public void moveForward(double speed){

  }

  //Run motors backward at certain speed
  public void moveBackward(double speed){

  }

  //Turn robot at certain speed
  public void turnRight(double speed){

  }

  //Turn robot at certain speed
  public void turnLeft(double speed){

  }
}
