package org.firstinspires.ftc.teamcode.alphaBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ViperSlideExtensionTesting")
public class viperSlideExtensionTesting extends LinearOpMode {


    private DcMotor viperSlide;

    private int slidePos1;
    private int slidePos2;
    private int slidePos3;


    @Override
    public void runOpMode() {

        viperSlide = hardwareMap.get(DcMotor.class, "armMotor");

        slidePos1 = 0;
        slidePos2 = 0;
        slidePos3 = 0;

        waitForStart();
    }

    private void extendLevel3(int target3, double speed) {
        slidePos3 += target3;
        viperSlide.setTargetPosition(slidePos3);
        viperSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperSlide.setPower(speed);
    }

    private void extendLevel2(int target2, double speed) {
        slidePos2 += target2;
        viperSlide.setTargetPosition(slidePos2);
        viperSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperSlide.setPower(speed);
    }

    private void extendLevel1(int target1, double speed) {
        slidePos1 += target1;
        viperSlide.setTargetPosition(slidePos1);
        viperSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperSlide.setPower(speed);


        while (opModeIsActive() && viperSlide.isBusy()) {
            double SpeedOfRobot = 0.1;
            double SpeedOfArm = 0.8;
            if (gamepad2.a) {
                extendLevel1(100, 0.5);
            } else {
                viperSlide.setPower(0);
            }
            if (gamepad2.b) {
                extendLevel2(200, 0.5);
            } else {
                viperSlide.setPower(0);
            }
            if (gamepad2.y) {
                extendLevel3(300, 0.5);
            } else {
                viperSlide.setPower(0);
            }


            if (gamepad2.dpad_up) {
                viperSlide.setPower(SpeedOfArm);
            } else if (gamepad2.dpad_down) {
                viperSlide.setPower(-SpeedOfArm);
            } else {
                viperSlide.setPower(0);
            }

        }
    }
}