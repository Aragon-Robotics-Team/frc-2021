package frc.robot.trajectory;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;

public class TrajectoryFactory {
    public static Trajectory generateTrajectory(String path) {
        String trajectoryJSON = "paths/"+path+".wpilib.json";
        Trajectory trajectory = new Trajectory();
        Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
        try {
          trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
        } catch (IOException e) {
          e.printStackTrace();
        }
    
        return trajectory;
    
      }
}
