// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX shoe;
  private Encoder laces;

  /** Creates a new Shooter. */
  public Shooter() {
    shoe = new WPI_TalonSRX(1);
    shoe.setInverted(true);

    laces = new Encoder(0, 1, true, EncodingType.k4X);
    laces.setDistancePerPulse(1.0/2048);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("shooter RPM", laces.getRate());
  }

  public void fire(double fast) {
    shoe.set(fast);
  }
}
