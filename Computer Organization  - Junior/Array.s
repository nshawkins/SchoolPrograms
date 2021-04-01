.data	# Data section
		# Assembler directive - does not result in code
        myArray: .space 100
        size: .asciiz "Enter an array size: "
        element: .asciiz "Enter an element: "
        print: .asciiz "Printing array: "
        space: .asciiz " "

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:
	#input array size
	
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, size         # place the address of the string to call in argument register
	syscall                # The actual system call
	
	addi $v0, $zero, 5     # System call code to read a int
	syscall 
	
	#saves size x4 into register t7
	addi $t6, $0, 4
	mult $v0, $t6
	mflo $t7
	
	#pointer for array set to 0
	addi $t5, $zero, 0
	la $t0, myArray
	
	input:
	
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, element      # place the address of the string to call in argument register
	syscall                # The actual system call
  
	addi $v0, $zero, 5     # System call code to read a int
	syscall 
	
	# store inputs into the array
	
	sw $v0, ($t0)
	
	#incrementation for array
	addi $t0, $t0, 4
	addi $t5, $t5, 4
	
	#provide terminate to input process
	beq $t5, $t7, printer
	
	j input
	
	printer: 
	
	#pointer for array set to 0
	addi $t5, $zero, 0
	addi $t0, $zero, 0
	
	# print an array one element at a time with a space
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, print        # place the address of the string to call in argument register
	syscall                # The actual system call
	
	continue:
	
	lw $t1, ($t0)
	
	li $v0, 1
	li $t1, 5
	#lw $t1, 5
	syscall
	
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, space        # place the address of the string to call in argument register
	syscall
	
	#incrementation for array
	addi $t0, $t0, 4
	addi $t5, $t5, 4
	
	beq $t5, $t7, Exit
	
	j continue

Exit:			# Label for the exit routine	
li $v0,10		# $v0 is a special register, and if its loaded with 
# addi $v0, $0, 10
syscall			# value 10, it means the program should terminate
			# All our programs should have this
