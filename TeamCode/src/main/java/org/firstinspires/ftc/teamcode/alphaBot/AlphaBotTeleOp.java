package org.firstinspires.ftc.teamcode.alphaBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "AlphaBotTeleOp")
public class AlphaBotTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor viperSlide;
    private Servo grabberRight;
    private Servo grabberLeft;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        viperSlide = hardwareMap.get(DcMotor.class, "viperSlide");
        grabberRight = hardwareMap.get(Servo.class, "grabberRight");
        grabberLeft = hardwareMap.get(Servo.class, "grabberLeft");

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();
        grabberRight.setDirection(Servo.Direction.REVERSE);
        grabberLeft.setPosition(0.1);
        grabberRight.setPosition(0.1);
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                double speed = 0.35;
                if (gamepad1.y) {
                    telemetry.addLine("Fast Speed");
                    speed = 1;
                } else {
                        telemetry.addLine("Regular Speed");
                        speed = 0.35;
                    }

                if (gamepad2.a) {
                    grabberLeft.setPosition(0.25);
                    grabberRight.setPosition(0.25);
                }
                if (gamepad2.b) {
                    grabberLeft.setPosition(0.1);
                    grabberRight.setPosition(0.1);
                }

                if (gamepad2.dpad_down) {
                    viperSlide.setPower(1);
                } else {
                    viperSlide.setPower(0);
                }
                if (gamepad2.dpad_up) {
                    viperSlide.setPower(-1);
                } else {
                    viperSlide.setPower(0);
                }

                if (gamepad1.dpad_down) {
                    frontLeft.setPower(-speed);
                    frontRight.setPower(-speed);
                    backLeft.setPower(-speed);
                    backRight.setPower(-speed);
                } else {
                    if (gamepad1.dpad_up) {
                        frontLeft.setPower(speed);
                        frontRight.setPower(speed);
                        backLeft.setPower(speed);
                        backRight.setPower(speed);
                    } else {
                        if (gamepad1.dpad_left) {
                            frontRight.setPower(speed);
                            frontLeft.setPower(-speed);
                            backLeft.setPower(-speed);
                            backRight.setPower(speed);
                        } else if (gamepad1.dpad_right) {
                            frontRight.setPower(-speed);
                            frontLeft.setPower(speed);
                            backLeft.setPower(speed);
                            backRight.setPower(-speed);
                        } else {
                            frontLeft.setPower(0);
                            frontRight.setPower(0);
                            backLeft.setPower(0);
                            backRight.setPower(0);
                            if (gamepad1.right_bumper) {
                                frontRight.setPower(-0.85);
                                frontLeft.setPower(0.85);
                                backRight.setPower(0.85);
                                backLeft.setPower(-0.85);
                            } else if (gamepad1.left_bumper) {
                                frontRight.setPower(0.85);
                                frontLeft.setPower(-0.85);
                                backRight.setPower(-0.85);
                                backLeft.setPower(0.85);
                            }
                        }
                    }
                }
            }

        }
    }
}
