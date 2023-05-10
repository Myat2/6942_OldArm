package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.geometry.Transform2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Globals;
import frc.robot.RobotContainer;

public class LoopMovetoB extends SequentialCommandGroup{
  public LoopMovetoB(String targetArea){
    super(
      
      new MovetoBWaypoint(),
      new InstantCommand(() -> Globals.cvMode = 3), 
      new WaitCommand(8),
      new InstantCommand(() -> RobotContainer.m_points.updateAllPoints()),
      new InstantCommand(() -> Globals.cvMode = -1),
      new CheckTrolleyinWaypoint()
    );
  }
  public LoopMovetoB(){
    super(
      
      new MovetoBWaypoint(),
      new InstantCommand(() -> Globals.cvMode = 4), 
      new WaitCommand(5), // Changes
      new InstantCommand(() -> RobotContainer.m_points.updateAllPoints()),
      new InstantCommand(() -> Globals.cvMode = -1),
      new CheckTrolleyinWaypoint()
    );
  }
}
