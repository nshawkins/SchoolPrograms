	
	.data	# Data section
		# Assembler directive - does not result in code
        intA: .word 2
        intB: .word 3
        intC: .word 3

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:

lw $t0, intA #lw is load word
lw $t1, intB
lw $t2, intC
add $t0, $t0, $t1
add $t1, $t0, $t2

sw $t1, intA #sw is store word
addi, $v0, $zero, 1
lw $a0, intA
syscall

Exit:			# Label for the exit routine	