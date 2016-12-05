package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by pedropetcov on 12/5/16.
 */
@TeleOp (name = "TeleOp Stuff", group = "TeleOp Stuff")
public class TeleOp extends LinearOpMode {
    {
        private DcMotor treadLeft;
        private DcMotor treadRight;

        @Override
        public void runOpMode ()throws InterruptedException {
        treadLeft = hardwareMap.dcMotor.get("treadLeft");
        treadRight = hardwareMap.dcMotor.get("treadRight");

        treadLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

         treadLeft.setPower(-gamepad1.left_stick_y);
         treadRight.setPower(-gamepad1.right_stick_y);

            idle();
        }
    }
    }


















    
}
