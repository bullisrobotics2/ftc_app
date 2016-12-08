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
@TeleOp (name = "TeleOp Stuff", group = "TeleOp Stuff")
public class TeleOp2 extends LinearOpMode {

    DcMotor treadLeft;
    DcMotor treadRight;
    DcMotor Pinball;

    public void runOpMode() throws InterruptedException {
        treadLeft = hardwareMap.dcMotor.get("treadLeft");
        treadRight = hardwareMap.dcMotor.get("treadRight");
        Pinball = hardwareMap.dcMotor.get("Pinball");

        treadLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {

            treadLeft.setPower(-gamepad1.left_stick_y);
            treadRight.setPower(-gamepad1.right_stick_y);
            Pinball.setPower(-gamepad1.right_trigger);
            treadLeft.setPower(-gamepad2.left_stick_y);
            treadRight.setPower(-gamepad2.right_stick_y);
            Pinball.setPower(-gamepad2.right_trigger);

            idle();
        }
    }

    public void particleLauncher() {
        try {
            if (-gamepad1.right_trigger == 1 || -gamepad2.right_trigger == 1) {
                Pinball.setPower(50);
                wait(2000);
            }
        }
        catch (InterruptedException ex) {
        }
    }
}



















