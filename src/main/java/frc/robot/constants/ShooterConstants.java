package frc.robot.constants;


import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.KilogramSquareMeters;


import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import yams.gearing.GearBox;
import yams.gearing.MechanismGearing;
import yams.motorcontrollers.SmartMotorControllerConfig;
import yams.motorcontrollers.SmartMotorControllerConfig.ControlMode;

public class ShooterConstants {
    	  public static final SmartMotorControllerConfig flywheelMotorConstants = new SmartMotorControllerConfig()
	      .withControlMode(ControlMode.CLOSED_LOOP)
	      // Feedback constants (PID), on the real robot and in simulation.
	      // A flywheel holds a speed, so it gets no motion profile.
	      .withClosedLoopController(0.2, 0, 0)
	      .withSimClosedLoopController(0.2, 0, 0)
	      // Feedforward constants, on the real robot and in simulation.
	      .withFeedforward(new SimpleMotorFeedforward(0, 0.19, 0))
	      .withSimFeedforward(new SimpleMotorFeedforward(0, 0.19, 0))
	      // Gearing from the motor rotor to the flywheel: one 1.5:1 stage.
	      .withGearing(new MechanismGearing(GearBox.fromReductionStages(1.5)))
	      // How hard the wheel is to spin up, used by the simulation: two 4 inch
	      // wheels, 0.68 kg (1.5 lb) in all, as solid discs: 0.5 x 0.68 kg x (0.0508 m)^2.
	      .withMomentOfInertia(KilogramSquareMeters.of(0.0009))
	      .withMotorInverted(false)
	      // Coast, so that the wheel spins down by itself instead of being braked to a stop.
	      .withIdleMode(SmartMotorControllerConfig.MotorMode.COAST)
	      .withStatorCurrentLimit(Amps.of(40))
	      // Telemetry name and how much to publish.
	      .withTelemetry("ShooterMotor", SmartMotorControllerConfig.TelemetryVerbosity.HIGH);
	
}
