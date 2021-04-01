.data	# Data section
		# Assembler directive - does not result in code
	myArray: .space 800
	enterGrade: .asciiz "Enter a grade: "
	printingA: .asciiz "Grades 90-100: "
	printingB: .asciiz "Grades 80-89: "
	printingC: .asciiz "Grades 70-79: "
	printingD: .asciiz "Grades 60-69: "
	printingF: .asciiz "Grades 59 and below: "
	A: .asciiz "A"
	B: .asciiz "B"
	C: .asciiz "C"
	D: .asciiz "D"
	F: .asciiz "F"
	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:

#input grades as ints from 0-100

	#data input is a function to showcase array
	
	input:
	
	#pointer for array
	addi $t0, $zero, 0
	#incrementation for array
	addi $t0, $t0, 4
	
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, enterGrade   # place the address of the string to call in argument register
	syscall                # The actual system call
  
	addi $v0, $zero, 5     # System call code to read a int
	syscall 
	
	#provide terminate to input process (sentinal)
	slt $t7, $v0, $zero
	bne $t7, $zero, continue
	
	#store grades to an array
	sw $v0, myArray($t0)
	addi $t0, $t0, 4
	
	j input
	
	continue:
	#classify grades as letter grades: A(90-100), B(80-89), C(70-79), D(60-69), F(<60)
	
	
	
	Printer:
	
	isA:
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, A            # place the address of the string to call in argument register
	syscall
	
	isB:
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, B            # place the address of the string to call in argument register
	syscall
	
	isC:
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, C            # place the address of the string to call in argument register
	syscall
	
	isD:
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, D            # place the address of the string to call in argument register
	syscall
	
	isF:
	addi $v0, $zero, 4     # system call code to print string
	la   $a0, F            # place the address of the string to call in argument register
	syscall

#print grades (how many As, Bs, Cs, Ds, Fs)

Exit:			# Label for the exit routine	
li $v0,10		# $v0 is a special register, and if its loaded with 
# addi $v0, $0, 10
syscall			# value 10, it means the program should terminate
			# All our programs should have this
