package org.firstinspires.ftc.teamcode;

/**
 * Created by Parker on 12/6/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by pedropetcov on 12/5/16.
 */
@Autonomous (name = "Autonomous Stuff", group = "Autonomous Stuff")
public class Autonomomus extends LinearOpMode {

    DcMotor treadLeft = null;
    DcMotor treadRight = null;
    DcMotor Pinball = null;

    public void runOpMode() throws InterruptedException {
        treadLeft = hardwareMap.dcMotor.get("treadLeft");
        treadRight = hardwareMap.dcMotor.get("treadRight");
        Pinball = hardwareMap.dcMotor.get("Pinball");


        treadLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            noDriver();
            idle();
        }
    }
    public void noDriver(){ //creates the method for Autonomous phase
        if (this.time <= 1){
            TurnRight();
        }
        if (this.time > 1 && this.time < 5){
            DriveForward();
        }
        if (this.time > 5 && this.time < 7){
            TurnRight();
        }
        if (this.time > 7 && this.time < 17){
            DriveForward();
        }
        if (this.time > 17 && this.time <= 18){
            Stop();
        }
        if (this.time >= 18 && this.time < 28) {
            particleLauncher();
        }
        if (this.time > 28 && this.time <= 30){
            stop();
        }
    }

    public void particleLauncher() { //sets the method for the particle launcher
        try {
            if (-gamepad1.right_trigger == 1 || -gamepad2.right_trigger == 1) { //allows people to access the motor
                Pinball.setPower(50); //sets the motor's power
                wait(20000); //delay for this power
            }
        }
        catch (InterruptedException ex) {
        }
    }
    public void DriveForward(){
        treadLeft.setPower(1);
        treadRight.setPower(1);
        //allows the robot to go forward
    }
    public void TurnLeft(){
        treadRight.setPower(1);
        treadLeft.setPower(-1);
        //allows the robot to turn Left
    }
    public void TurnRight(){
        treadLeft.setPower(1);
        treadRight.setPower(-1);
        //allows the robot to turn right
    }
    public void Backward(){
        treadLeft.setPower(-1);
        treadRight.setPower(-1);
        //allows the robot to go backwards
    }
    public void Stop(){
        treadLeft.setPower(0);
        treadRight.setPower(0);
        //allows the robot to stop
    }
}



















