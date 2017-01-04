package org.firstinspires.ftc.teamcode;

/**
 * Created by Parker on 12/12/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "TeleOp Phase", group = "TeleOp Comp Edition")
public class Esteban extends LinearOpMode{

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor shooterWheel;
    DcMotor collecterBottom;
    DcMotor collecterTop;
    final static double SPEED = 1;


    public void runOpMode() throws InterruptedException{
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        shooterWheel = hardwareMap.dcMotor.get("shooterWheel");
        collecterBottom = hardwareMap.dcMotor.get("collecterBottom");
        collecterTop = hardwareMap.dcMotor.get("collecterTop");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()){
            if(gamepad1.right_bumper == true) {
                strafeRight();
            }
            else if(gamepad1.left_bumper == true) {
                strafeLeft();
            }else {
                frontLeft.setPower(-gamepad1.left_stick_x);
                frontRight.setPower(-gamepad1.right_stick_x);
                backLeft.setPower(-gamepad1.left_stick_y);
                backRight.setPower(-gamepad1.right_stick_y);
                collecters();
            }
            idle();
        }
    }
    public void strafeRight(){
        if (gamepad1.right_bumper == true){
            frontRight.setPower(-1);
            backRight.setPower(1);
            frontLeft.setPower(1);
            backLeft.setPower(-1);
        }
    }
    public void strafeLeft(){
        if (gamepad1.left_bumper == true){
            frontRight.setPower(1);
            backRight.setPower(-1);
            frontLeft.setPower(-1);
            backLeft.setPower(1);
        }
    }
    public void shooter(){
        if (gamepad1.right_trigger == 0.5){
            shooterWheel.setPower(1);
        }
    }
    public void collecters(){
        collecterBottom.setPower(SPEED);
        collecterTop.setPower(SPEED);
    }
}
