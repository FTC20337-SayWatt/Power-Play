package org.firstinspires.ftc.teamcode.alphaBot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.JavaUtil;

@Autonomous(name = "EncoderDrive", preselectTeleOp = "AlphaBotTeleOp")
public class EncoderDrive extends LinearOpMode {
    private ColorSensor colorSensor;
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor  backLeft;
    private Servo grabberRight;
    private Servo grabberLeft;
    private DcMotor viperSlide;
    private int leftPos;
    private int rightPos;
    @Override
    public void runOpMode() throws InterruptedException{
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

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        colorSensor.enableLed(false);
        colorSensor.enableLed(true);

        leftPos = 0;
        rightPos = 0;

        waitForStart();
        grabberRight.setDirection(Servo.Direction.REVERSE);
        grabberLeft.setPosition(0.1);
        grabberRight.setPosition(0.1);
        strafeLeft(1200, 1200, 0.4);
        Thread.sleep(1200);
        strafeRight(1350, 1350, 0.4);
        Thread.sleep(1350);
        drive(1800, 1800, 0.3);
        Thread.sleep(1800);
        stop(900);

        if (isStarted()) {
            CurrentColor = JavaUtil.rgbToHue(colorSensor.red(), colorSensor.green(), colorSensor.blue());
            telemetry.addData("Hue", CurrentColor);
            telemetry.update();

            if (CurrentColor < 240 & CurrentColor > 165) {
                parkingSpot = 1;
            } else if (CurrentColor < 165 & CurrentColor > 125) {
                parkingSpot = 2;
            } else {
                parkingSpot = 3;
            }
        }
        if (parkingSpot == 1) {
            telemetry.addLine("Hue Detected. Move to Parking Spot 1");
            drive(1450, 1450, 0.4);
            Thread.sleep(1450);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            drive(1200, 1200, 0.4);
            Thread.sleep(1200);
            stop(300);
            extendSlide(1,525);
            Thread.sleep(150);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            extendSlide(1, 150);
            viperSlide.setPower(0.3);
            driveBack(300, 300, 0.4);
            Thread.sleep(300);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            strafeLeft(3350, 3350, 0.4);
            Thread.sleep(3350);
            drive(375, 375, 0.4);
            Thread.sleep(375);
            stop(825);
            grabberRight.setPosition(0.1);
            grabberLeft.setPosition(0.1);
            stop(250);
            strafeRight(1375, 1375, 0.4);
            Thread.sleep(1375);
            drive(500, 500, 0.4);
            Thread.sleep(500);
        }

        if (parkingSpot == 2) {
            telemetry.addLine("Hue Detected. Move to Parking Spot 2");
            drive(1450, 1450, 0.4);
            Thread.sleep(1450);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            drive(1300, 1300, 0.4);
            Thread.sleep(1300);
            stop(300);
            extendSlide(1,425);
            Thread.sleep(150);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            extendSlide(1, 900);
            viperSlide.setPower(0.2);
            driveBack(375, 375, 0.4);
            Thread.sleep(375);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            strafeLeft(3350, 3350, 0.4);
            Thread.sleep(3350);
            drive(375, 375, 0.4);
            Thread.sleep(375);
            stop(825);
            grabberRight.setPosition(0.1);
            grabberLeft.setPosition(0.1);
            stop(350);
            strafeRight(1575, 1575, 0.4);
            Thread.sleep(1575);
        }
        if (parkingSpot == 3) {
            telemetry.addLine("Hue Detected. Move to Parking Spot 3");
            drive(1450, 1450, 0.4);
            Thread.sleep(1450);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            drive(1200, 1200, 0.4);
            Thread.sleep(1200);
            stop(300);
            extendSlide(1,425);
            Thread.sleep(150);
            grabberLeft.setPosition(0.25);
            grabberRight.setPosition(0.25);
            extendSlide(1, 900);
            viperSlide.setPower(0.2);
            driveBack(300, 300, 0.4);
            Thread.sleep(300);
            turnLeft(1150, 1150, 0.4);
            Thread.sleep(1150);
            strafeLeft(3350, 3350, 0.4);
            Thread.sleep(3350);
            drive(375, 375, 0.4);
            Thread.sleep(375);
            stop(825);
            grabberRight.setPosition(0.1);
            grabberLeft.setPosition(0.1);
            stop(350);
            strafeRight(800, 800, 0.4);
            Thread.sleep(800);
        }

    }

    public void drive(int leftTarget, int rightTarget, double speed) throws InterruptedException {
        leftPos += leftTarget;
        rightPos += rightTarget;


        frontLeft.setTargetPosition(leftPos);
        backLeft.setTargetPosition(leftPos);
        frontRight.setTargetPosition(rightPos);
        backRight.setTargetPosition(rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);


    }


    public void strafeLeft( int leftTarget, int rightTarget, double speed) throws InterruptedException  {
        leftPos += leftTarget;
        rightPos += rightTarget;

        frontLeft.setTargetPosition(-leftPos);
        backLeft.setTargetPosition(leftPos);
        frontRight.setTargetPosition(rightPos);
        backRight.setTargetPosition(-rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
    }
    public void strafeRight( int leftTarget, int rightTarget, double speed) throws InterruptedException  {
        leftPos += leftTarget;
        rightPos += rightTarget;

        frontLeft.setTargetPosition(leftPos);
        backLeft.setTargetPosition(-leftPos);
        frontRight.setTargetPosition(-rightPos);
        backRight.setTargetPosition(rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
    }
    public void stop(long time) throws InterruptedException {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        Thread.sleep(time);
    }
    public void turnRight(int leftTarget, int rightTarget, double speed) throws InterruptedException  {
        leftPos += leftTarget;
        rightPos += rightTarget;

        frontLeft.setTargetPosition(leftPos);
        backLeft.setTargetPosition(leftPos);
        frontRight.setTargetPosition(-rightPos);
        backRight.setTargetPosition(-rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
    }
    public void turnLeft(int leftTarget, int rightTarget, double speed) throws InterruptedException  {
        leftPos += leftTarget;
        rightPos += rightTarget;

        frontLeft.setTargetPosition(-leftPos);
        backLeft.setTargetPosition(-leftPos);
        frontRight.setTargetPosition(rightPos);
        backRight.setTargetPosition(rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
    }
    private void extendSlide(double speed, long time) throws InterruptedException {
        viperSlide.setPower(speed);
        Thread.sleep(time);
        viperSlide.setPower(0);

    }
    public void driveBack(int leftTarget, int rightTarget, double speed) throws InterruptedException {
        leftPos += leftTarget;
        rightPos += rightTarget;


        frontLeft.setTargetPosition(-leftPos);
        backLeft.setTargetPosition(-leftPos);
        frontRight.setTargetPosition(-rightPos);
        backRight.setTargetPosition(-rightPos);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);


    }
}
