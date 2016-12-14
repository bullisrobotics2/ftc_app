package org.firstinspires.ftc.teamcode;

/**
 * Created by Parker on 12/12/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "TeleOp Phase", group = "TeleOp Comp Edition")
public class Esteban extends LinearOpMode{

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;

    public void runOpMode() throws InterruptedException{
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

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
                frontLeft.setPower(-gamepad1.left_stick_y);
                frontRight.setPower(-gamepad1.right_stick_y);
                backLeft.setPower(-gamepad1.left_stick_y);
                backRight.setPower(-gamepad1.right_stick_y);

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
}
