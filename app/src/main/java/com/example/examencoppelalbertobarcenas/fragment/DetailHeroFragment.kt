package com.example.examencoppelalbertobarcenas.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.examencoppelalbertobarcenas.fragment.ViewModel.DetailHeroViewModel
import com.example.examencoppelalbertobarcenas.databinding.DetailHeroFragmentBinding
import com.example.examencoppelalbertobarcenas.model.response.*
import com.squareup.picasso.Picasso

class DetailHeroFragment : Fragment() {

    private val TAG = "DetailHeroFragment: "
    private var _binding: DetailHeroFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailHeroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailHeroFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observable()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            var id = getArguments()?.getString("id")

            viewModel.getDetails(id!!)
        }
    }

    fun observable(){
        viewModel.detailHeroModel.observe(this, Observer {
            val resultDetails = it

            binding.tvName.setText(resultDetails.name)
            Picasso.get().load(resultDetails.image.url).fit().centerCrop().into(binding.ivImageDetail)

            setPowerstats(resultDetails.powerstats)
            setBiography(resultDetails.biography)
            setAppearance(resultDetails.appearance)
            setWork(resultDetails.work)
            setConnections(resultDetails.connections)
        })
    }

    private fun setPowerstats(powerstats: PowerstatsResponse?) {
        with(binding) {
            tvIntelligence.setText(powerstats!!.intelligence)
            tvStrength.setText(powerstats!!.strength)
            tvSpeed.setText(powerstats!!.speed)
            tvDurability.setText(powerstats!!.durability)
            tvPower.setText(powerstats!!.power)
            tvCombat.setText(powerstats!!.combat)
        }
    }

    private fun setBiography(biography: BiographyResponse?) {
        with(binding) {
            tvFullName.setText(biography!!.fullName)
            tvAlterEgos.setText(biography!!.alterEgos)
            tvPlaceBirth.setText(biography!!.placeBirth)
            tvFirstAppearance.setText(biography!!.firstAppearance)
            tvPublisher.setText(biography!!.publisher)
            tvAlignment.setText(biography!!.alignment)
        }
    }

    private fun setAppearance(appearance: AppearanceResponse?) {
        with(binding) {
            tvGender.setText(appearance!!.gender)
            tvRace.setText(appearance!!.race)
            tvHeight.setText(appearance!!.height?.get(1))
            tvWeight.setText(appearance!!.weight?.get(1))
            tvEyeColor.setText(appearance!!.eyeColor)
            tvHairColor.setText(appearance!!.hairColor)
        }
    }

    private fun setWork(work: WorkResponse?) {
        with(binding) {
            tvOccupation.setText(work!!.occupation)
        }
    }

    private fun setConnections(connections: ConnectionsResponse?) {
        with(binding) {
            tvGroupAffiliation.setText(connections!!.groupAffiliation)
            tvRelatives.setText(connections!!.relatives)
        }
    }

}