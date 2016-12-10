package org.firstinspires.ftc.teamcode;

/**
 * Created by Parker on 12/6/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by pedropetcov on 12/5/16.
 */
@TeleOp (name = "TeleOp Comp. Edition", group = "TeleOp Comp. Edition")
public class TeleOptest extends LinearOpMode {

    DcMotor treadLeft; //creates a motor for the left tread
    DcMotor treadRight; //creates a motor for the right tread
    DcMotor Pinball; // creates a motor for the pinball

    public void runOpMode() throws InterruptedException {
        treadLeft = hardwareMap.dcMotor.get("treadLeft");
        treadRight = hardwareMap.dcMotor.get("treadRight");
        Pinball = hardwareMap.dcMotor.get("Pinball");

        treadLeft.setDirection(DcMotorSimple.Direction.REVERSE); //sets the left tread to go reverse so we go forwards
        Pinball.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            treadLeft.setPower(-gamepad1.left_stick_y);
            treadRight.setPower(-gamepad1.right_stick_y);
            Pinball.setPower(-gamepad1.right_trigger);
            //sets the controls for the motors so they can control the robot
            idle();
        }
    }

    public void particleLauncher() { //creates the method for the particle launcher
        try {
            if (-gamepad1.right_trigger == 1) { //when these buttons are pressed do below
                Pinball.setPower(0.5); //sets the motor power
                wait(200000); //makes the robot wait for the time
            }
        }
        catch (InterruptedException ex) { //fixes any interrupted exception errors
        }
    }
}



















