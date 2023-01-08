package org.firstinspires.ftc.teamcode.alphaBot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.JavaUtil;

@Autonomous(name = "AutoRightBackUp", preselectTeleOp = "AlphaBotTeleOp")
public class AutoRightBackUp extends LinearOpMode {
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
        strafeRight(1200, 1200, 0.4);
        Thread.sleep(1200);
        strafeLeft(1350, 1350, 0.4);
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
            strafeLeft(1375, 1375, 0.4);
            Thread.sleep(1375);
            drive(500, 500, 0.4);
            Thread.sleep(500);
        }

        if (parkingSpot == 2) {
            telemetry.addLine("Hue Detected. Move to Parking Spot 2");
            drive(500, 500, 0.4);
            Thread.sleep(500);
        }
        if (parkingSpot == 3) {
            telemetry.addLine("Hue Detected. Move to Parking Spot 3");
            strafeRight(1375, 1375, 0.4);
            Thread.sleep(1375);
            drive(500, 500, 0.4);
            Thread.sleep(500);
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

}
