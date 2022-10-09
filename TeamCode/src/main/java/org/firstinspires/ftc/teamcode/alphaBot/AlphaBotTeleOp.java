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
        private CRServo claw;
        private int slidePos1;
        private int slidePos2;
        private int slidePos3;
        private int slidePos4;

        @Override
        public void runOpMode() {
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            viperSlide = hardwareMap.get(DcMotor.class, "armMotor");
            claw = hardwareMap.get(CRServo.class, "intake");

            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
            frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
            backRight.setDirection(DcMotorSimple.Direction.REVERSE);
            slidePos1 = 0;
            slidePos2 = 0;
            slidePos3 = 0;
            slidePos4 = 0;

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
        } private void extendLevel4(int target4, double speed) {
            slidePos4 += target4;
            viperSlide.setTargetPosition(slidePos4);
            viperSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            viperSlide.setPower(speed);

                while (opModeIsActive() && viperSlide.isBusy()) {
                    double SpeedOfRobot = 0.1;
                    double SpeedOfArm = 0.8;
                    if (gamepad2.a) {
                        extendLevel1(100, 0.25);
                    } else {
                        viperSlide.setPower(0);
                    }
                    if (gamepad2.b) {
                        extendLevel2(200, 0.25);
                    } else {
                        viperSlide.setPower(0);
                    }
                    if (gamepad2.y) {
                        extendLevel3(300, 0.25);
                    } else {
                        viperSlide.setPower(0);
                    }
                    if(gamepad2.x) {
                        extendLevel4(400,0.25);
                    }

                    if (gamepad2.left_bumper) {
                        claw.setPower(1);
                    } else if (gamepad2.right_bumper) {
                        claw.setPower(-1);
                    } else {
                        claw.setPower(0);
                    }


                    if (gamepad2.dpad_up) {
                        viperSlide.setPower(SpeedOfArm);
                    } else if (gamepad2.dpad_down) {
                        viperSlide.setPower(-SpeedOfArm);
                    } else {
                        viperSlide.setPower(0);
                    }

                    if (gamepad1.dpad_up) {
                        frontLeft.setPower(-SpeedOfRobot);
                        frontRight.setPower(-SpeedOfRobot);
                        backLeft.setPower(-SpeedOfRobot);
                        backRight.setPower(-SpeedOfRobot);
                    } else if (gamepad1.dpad_down) {
                        frontLeft.setPower(SpeedOfRobot);
                        frontRight.setPower(SpeedOfRobot);
                        backLeft.setPower(SpeedOfRobot);
                        backRight.setPower(SpeedOfRobot);
                    } else if (gamepad1.dpad_right) {
                        frontRight.setPower(SpeedOfRobot);
                        frontLeft.setPower(-SpeedOfRobot);
                        backRight.setPower(SpeedOfRobot);
                        backLeft.setPower(-SpeedOfRobot);
                    } else if (gamepad1.dpad_left) {
                        frontRight.setPower(-SpeedOfRobot);
                        frontLeft.setPower(SpeedOfRobot);
                        backRight.setPower(-SpeedOfRobot);
                        backLeft.setPower(SpeedOfRobot);
                    } else {
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        backLeft.setPower(0);
                        backRight.setPower(0);
                        if (gamepad1.right_bumper) {
                            frontRight.setPower(-SpeedOfRobot);
                            frontLeft.setPower(SpeedOfRobot);
                            backRight.setPower(SpeedOfRobot);
                            backLeft.setPower(-SpeedOfRobot);
                        } else if (gamepad1.left_bumper) {
                            frontRight.setPower(SpeedOfRobot);
                            frontLeft.setPower(-SpeedOfRobot);
                            backRight.setPower(-SpeedOfRobot);
                            backLeft.setPower(SpeedOfRobot);
                        }
                    }
                }
            }


        }