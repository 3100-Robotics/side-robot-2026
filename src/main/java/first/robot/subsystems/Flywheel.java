package first.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ShooterConstants;
import edu.wpi.first.math.system.plant.DCMotor;

import yams.motorcontrollers.SmartMotorController;
import yams.motorcontrollers.local.SparkWrapper;

public class Flywheel extends SubsystemBase {
	
	  // What the motor controller should do: its control mode, gains and gearing.

	  // The vendor motor controller object: a SPARK MAX with CAN ID 4.
	private final SparkMax spark =
    new SparkMax(4, MotorType.kBrushless);

	
	  // The SmartMotorController applies the config to the SPARK MAX, which drives one NEO. It takes in the constants from ShooterConstants MotorConfig, which is a SmartMotorControllerConfig object that contains the control mode, gains, gearing, and other settings for the motor controller.
	private final SmartMotorController motor = new SparkWrapper(spark, DCMotor.getNEO(1), ShooterConstants.flywheelMotorConstants);

}