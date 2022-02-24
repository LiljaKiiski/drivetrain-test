// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
 
  TalonFX motorA1;
  TalonFX motorA2;

  TalonFX motorB1;
  TalonFX motorB2;

  public DrivetrainSubsystem() {
    motorA1 = new TalonFX(0);
    motorA2 = new TalonFX(1);
    motorB1 = new TalonFX(2);
    motorB2 = new TalonFX(3);
  }

  public void moveForwardRight(double speed){

  }

  public void moveForwardLeft(double speed){

  }

  public void moveBackwardRight(double speed){

  }

  public void moveBackwardLeft(double speed){
    
  }

  public void moveForward(double speed){
    setAllMotorSpeeds(speed);
  }

  public void moveBackward(double speed){
    setAllMotorSpeeds(speed);
  }

  public void stopAllMotors(){
    setAllMotorSpeeds(0);
  }

  public void setAllMotorSpeeds(double speed){
    setForwardMotorSpeeds(speed);
    setBackMotorSpeeds(speed);
  }

  public void setForwardMotorSpeeds(double speed){
    motorA1.set(ControlMode.PercentOutput, speed);
    motorA2.set(ControlMode.PercentOutput, speed);
  }

  public void setBackMotorSpeeds(double speed){
    motorB1.set(ControlMode.PercentOutput, speed);
    motorB2.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
   
  }
}
