package org.firstinspires.ftc.teamcode.alphaBot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.JavaUtil;

@Autonomous(name = "AutonomousRight", preselectTeleOp = "AlphaBotTeleOp")
public class AutonomousRight extends LinearOpMode {

    private ColorSensor colorSensor;
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private Servo grabberRight;
    private Servo grabberLeft;
    private DcMotor viperSlide;


    @Override
    public void runOpMode() throws InterruptedException {
        float CurrentColor;
        float parkingSpot = 0;

        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        grabberRight = hardwareMap.get(Servo.class, "grabberRight");
        grabberLeft = hardwareMap.get(Servo.class, "grabberLeft");
        viperSlide = hardwareMap.get(DcMotor.class, "viperSlide");

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        colorSensor.enableLed(false);
        colorSensor.enableLed(true);
        waitForStart();
        grabberRight.setDirection(Servo.Direction.REVERSE);
        grabberLeft.setPosition(0.1);
        grabberRight.setPosition(0.1);
        drive(0.3, 500);
        strafeRight(0.4,1350);
        strafeLeft(0.4, 1350);
        drive(0.3, 1225);
        Thread.sleep(500);

        if (isStarted()) {
            CurrentColor = JavaUtil.rgbToHue(colorSensor.red(), colorSensor.green(), colorSensor.blue());
            telemetry.addData("Hue", CurrentColor);
            telemetry.update();

            if (CurrentColor < 220 & CurrentColor > 165) {
                parkingSpot = 1;
            } else if (CurrentColor < 170 & CurrentColor > 125) {
                parkingSpot = 2;
            } else {
                parkingSpot = 3;
            }
        }

        if (parkingSpot == 1) {
            Thread.sleep(450);
            telemetry.addLine("Hue Detected. Move to Parking Spot 1");
            drive(0.4, 1400);
            Thread.sleep(150);
            turn(0.3, 120, false);
            Thread.sleep(150);
            strafeLeft(0.4, 200);
            Thread.sleep(150);
            drive(0.3, 1400);
            Thread.sleep(150);
            drive(-0.3, 800);
            turn(0.3,1575,true);
            Thread.sleep(150);
            drive(0.3, 1625);
            Thread.sleep(150);
            extendSlide(1,600);
            Thread.sleep(5);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            Thread.sleep(300);
            extendSlide(1,350);
            Thread.sleep(150);
            drive(-0.3,925);
            strafeLeft(0.3, 500);
            turn(0.3, 1875, true);
            extendSlide(1,875);
            Thread.sleep(30);
            drive(0.3, 300);
            Thread.sleep(150);
            grabberLeft.setPosition(0.1);
            grabberRight.setPosition(0.1);
            Thread.sleep(150);
            drive(-0.3, 150);
            Thread.sleep(150);
            strafeRight(0.5, 3250);
            Thread.sleep(150);
            drive(0.3, 1000);
            Thread.sleep(150);
            turn(0.3, 275, false);
        } else {
            idle();
        }
        if (parkingSpot == 2) {
            Thread.sleep(450);
            telemetry.addLine("Hue Detected. Move to Parking Spot 2");
            drive(0.3, 1400);
            Thread.sleep(150);
            turn(0.3, 120, false);
            Thread.sleep(150);
            strafeLeft(0.4, 200);
            Thread.sleep(150);
            drive(0.3, 1400);
            Thread.sleep(150);
            drive(-0.3, 800);
            turn(0.3,1575,true);
            Thread.sleep(150);
            drive(0.3, 1625);
            Thread.sleep(150);
            extendSlide(1,600);
            Thread.sleep(5);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            Thread.sleep(300);
            extendSlide(1,350);
            Thread.sleep(150);
            drive(-0.3,925);
            strafeLeft(0.3, 500);
            turn(0.3, 1875, true);
            extendSlide(1,875);
            Thread.sleep(30);
            drive(0.3, 300);
            Thread.sleep(150);
            grabberLeft.setPosition(0.1);
            grabberRight.setPosition(0.1);
            Thread.sleep(150);
            drive(-0.3, 150);
            Thread.sleep(150);
            strafeRight(0.3, 1050);
            Thread.sleep(150);
            drive(0.3, 900);
        } else {
            idle();
        }
        if (parkingSpot == 3) {
            Thread.sleep(450);
            telemetry.addLine("Hue Detected. Move to Parking Spot 3");
            drive(0.3, 1400);
            Thread.sleep(150);
            turn(0.3, 120, false);
            Thread.sleep(150);
            strafeLeft(0.4, 200);
            Thread.sleep(150);
            drive(0.3, 1400);
            Thread.sleep(150);
            drive(-0.3, 800);
            turn(0.3,1575,true);
            Thread.sleep(150);
            drive(0.3, 1625);
            Thread.sleep(150);
            extendSlide(1,600);
            Thread.sleep(5);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            Thread.sleep(300);
            extendSlide(1,350);
            Thread.sleep(150);
            drive(-0.3,925);
            strafeLeft(0.3, 500);
            turn(0.3, 1875, true);
            extendSlide(1,875);
            Thread.sleep(30);
            drive(0.3, 300);
            Thread.sleep(150);
            grabberLeft.setPosition(0.1);
            grabberRight.setPosition(0.1);
            Thread.sleep(150);
            drive(-0.3, 150);
            Thread.sleep(150);
            strafeLeft(0.3, 1300);
            Thread.sleep(150);
            drive(0.3, 950);
        } else {
            idle();
        }
    }

    public void drive(double speed, long time) throws InterruptedException {
        frontLeft.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
        backRight.setPower(speed);
        Thread.sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void strafeLeft(double speed, long time) throws InterruptedException {
        frontRight.setPower(speed);
        frontLeft.setPower(-speed);
        backRight.setPower(-speed);
        backLeft.setPower(speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }
    private void strafeRight(double speed, long time) throws InterruptedException {
        frontRight.setPower(-speed);
        frontLeft.setPower(speed);
        backRight.setPower(speed);
        backLeft.setPower(-speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

    }
    public void turn(double speed, long time, boolean right) throws  InterruptedException {
        if (right) {
            frontRight.setPower(-speed);
            frontLeft.setPower(speed);
            backRight.setPower(-speed);
            backLeft.setPower(speed);
        } else {
            frontRight.setPower(speed);
            frontLeft.setPower(-speed);
            backRight.setPower(speed);
            backLeft.setPower(-speed);
        }
        Thread.sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
    private void extendSlide(double speed, long time) throws InterruptedException {
        viperSlide.setPower(speed);
        Thread.sleep(time);
        viperSlide.setPower(0);
    }
    private void grab(double position) throws InterruptedException {
        grabberLeft.setPosition(position);
        grabberRight.setPosition(position);

    }


}
