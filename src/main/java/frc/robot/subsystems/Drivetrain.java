// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  public WPI_TalonFX l1, l2, r1, r2;
  public MotorControllerGroup l, r;
  public DifferentialDrive ddrive;


  public Drivetrain() {
    l1 = new WPI_TalonFX(Constants.MOTOR_L1_ID);
    l2 = new WPI_TalonFX(Constants.MOTOR_L2_ID);
    r1 = new WPI_TalonFX(Constants.MOTOR_R1_ID);
    r2 = new WPI_TalonFX(Constants.MOTOR_R2_ID);

    r1.setInverted(true);
    r2.setInverted(true);

    l2.follow(l1);
    r2.follow(r1);

    l = new MotorControllerGroup(l1, l2);
    r = new MotorControllerGroup(r1, r2);
    ddrive = new DifferentialDrive(l, r);
  }

  public void moveRobot(double left, double right) {
    // This method will be called once per scheduler run
      l1.set(ControlMode.PercentOutput, left);
      r1.set(ControlMode.PercentOutput, right);
      
  }
}
