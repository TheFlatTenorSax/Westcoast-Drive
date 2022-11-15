// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveCommand extends CommandBase {
  /** Creates a new Drivetrain. */
  public DriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left, right;
    double throttle, turn;
    final double driveSens = 0.05;
    final double turnSens = 0.02;
    final double turnInPlaceSens = 0.03;
    throttle = RobotContainer.getThrottle();
    turn = RobotContainer.getTurn();
    if(throttle != 0){
      throttle = throttle * driveSens;
      turn = turn * turnSens; 
      left = (throttle + throttle * turn * turnSens) * driveSens;
      right = (throttle - throttle * turn * turnSens) * driveSens;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
