package pt.leite.valerio.blissapplicationschallenge.ui.repos_list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.leite.valerio.blissapplicationschallenge.ui.base.BlissRecyclerViewAdapter
import pt.leite.valerio.blissapplicationschallenge.ui.repos_list.models.RepoUI
import pt.leite.valerio.blissapplicationschallenge.ui.repos_list.views.RepoItemView

class RepoItemAdapter: BlissRecyclerViewAdapter<RepoUI>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(RepoItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position)!!)
    }

    inner class ViewHolder(private val view: RepoItemView): RecyclerView.ViewHolder(view) {
        fun bind(repoUI: RepoUI) {
            view.setName(repoUI.name)
            view.setOnClickListener {
                removeItem(repoUI)
            }
        }
    }
}