// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  TalonSRX motorA1;
  TalonSRX motorA2;
  TalonSRX motorB1;
  TalonSRX motorB2;

  final double SPEED;

  public DrivetrainSubsystem() {
    motorA1 = new TalonSRX(19);
    motorA2 = new TalonSRX(7);
    motorB1 = new TalonSRX(16);
    motorB2 = new TalonSRX(61);

    motorB1.setInverted(true);
    motorB2.setInverted(true);

    SPEED = 0.2;
  }

  public void turnRight(){
    setMotorASpeeds(SPEED);
    setMotorBSpeeds(0);
  }

  public void turnLeft(){
    setMotorASpeeds(0);
    setMotorBSpeeds(SPEED);
  }

  public void moveForward(){
    setAllMotorSpeeds(-SPEED);
  }

  public void moveBackward(){
    setAllMotorSpeeds(SPEED);
  }

  public void stopAllMotors(){
    setAllMotorSpeeds(0);
  }

  public void setAllMotorSpeeds(double speed){
    setMotorASpeeds(speed);
    setMotorBSpeeds(speed);
  }

  public void setMotorASpeeds(double speed){
    motorA1.set(ControlMode.PercentOutput, speed);
    motorA2.set(ControlMode.PercentOutput, speed);
  }

  public void setMotorBSpeeds(double speed){
    motorB1.set(ControlMode.PercentOutput, speed);
    motorB2.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
   
  }
}