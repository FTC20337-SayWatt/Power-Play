package org.firstinspires.ftc.teamcode.bravoBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="ViperSlideTest")
public class ViperSlideTest extends LinearOpMode {
    private DcMotor viperSlide;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        viperSlide = hardwareMap.get(DcMotor.class, "viperSlide");

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                viperSlide.setPower(1);
            }  else {
                viperSlide.setPower(0);
            }
        }
    }
}
